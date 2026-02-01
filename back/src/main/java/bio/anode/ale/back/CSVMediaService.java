package bio.anode.ale.back;

import bio.anode.ale.service.MediaService;
import bio.anode.ale.core.specifications.Media;
import org.apache.commons.csv.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class CSVMediaService implements MediaService {

    private final Path mediaFile;

    public CSVMediaService(String filePath) {
        this.mediaFile = Path.of(filePath);
        ensureFileExists();
    }

    public CSVMediaService(Path filePath) {
        this.mediaFile = filePath;
        ensureFileExists();
    }

    private void ensureFileExists() {
        try {
            if (!Files.exists(mediaFile)) {
                Files.createFile(mediaFile);
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to create media file", e);
        }
    }

    @Override
    public List<Media> getMedia() {
        try (Reader reader = Files.newBufferedReader(mediaFile)) {

            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .withHeader("id", "code", "alternativeCode", "label", "viscosity", "density")
                    .withSkipHeaderRecord()
                    .parse(reader);

            List<Media> list = new ArrayList<>();

            for (CSVRecord r : records) {
                Media m = new Media();
                m.setId(r.get("id"));
                m.setCode(r.get("code"));
                m.setAlternativeCode(r.get("alternativeCode"));
                m.setLabel(r.get("label"));
                m.setViscosity(parseDouble(r.get("viscosity")));
                m.setDensity(parseDouble(r.get("density")));
                list.add(m);
            }

            return list;

        } catch (IOException e) {
            throw new RuntimeException("Error reading media CSV", e);
        }
    }

    @Override
    public void updateMediaFromStrings(List<String> csvLines) {
        try (BufferedWriter writer = Files.newBufferedWriter(mediaFile)) {
            for (String line : csvLines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to update CSV", e);
        }
    }

    @Override
    public List<String> exportMediaToCSV(String filter) {
        return getMedia().stream()
                .filter(m -> filter == null || m.getCode().contains(filter))
                .map(this::toCsvLine)
                .collect(Collectors.toList());
    }

    @Override
    public Media getMedium(String code) {
        return getMedia().stream()
                .filter(m -> m.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }

    /* ---------------- Helper Methods ---------------- */

    private double parseDouble(String s) {
        try {
            return s == null || s.isBlank() ? 0 : Double.parseDouble(s);
        } catch (Exception e) {
            return 0;
        }
    }

    private String toCsvLine(Media m) {
        return String.join(",",
                safe(m.getId()),
                safe(m.getCode()),
                safe(m.getAlternativeCode()),
                safe(m.getLabel()),
                Double.toString(m.getViscosity()),
                Double.toString(m.getDensity())
        );
    }

    private String safe(Object o) {
        return o == null ? "" : o.toString();
    }
}

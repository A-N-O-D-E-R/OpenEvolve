package bio.anode.ale.back;

import bio.anode.ale.core.specifications.Operator;
import bio.anode.ale.service.OperatorService;
import org.apache.commons.csv.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class CSVOperatorService implements OperatorService {

    private final Path operatorFile;

    public CSVOperatorService(String filePath) {
        this.operatorFile = Path.of(filePath);
        ensureFileExists();
    }

    public CSVOperatorService(Path filePath) {
        this.operatorFile = filePath;
        ensureFileExists();
    }

    private void ensureFileExists() {
        try {
            if (!Files.exists(operatorFile)) {
                Files.createFile(operatorFile);
                // write CSV header
                try (BufferedWriter writer = Files.newBufferedWriter(operatorFile)) {
                    writer.write("code,name,surname,email\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize operator CSV file: " + operatorFile, e);
        }
    }

    @Override
    public List<Operator> getOperators() {
        List<Operator> list = new ArrayList<>();

        try (Reader reader = Files.newBufferedReader(operatorFile)) {

            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .withHeader("code", "name", "surname", "email")
                    .withSkipHeaderRecord()
                    .parse(reader);

            for (CSVRecord r : records) {
                Operator op = new Operator();
                op.setCode(r.get("code"));
                op.setName(r.get("name"));
                op.setSurname(r.get("surname"));
                op.setEmail(r.get("email"));
                list.add(op);
            }

        } catch (IOException e) {
            throw new RuntimeException("Error reading operator CSV", e);
        }

        return list;
    }

    @Override
    public void updateOperatorsFromStrings(List<String> csvLines) {
        try (BufferedWriter writer = Files.newBufferedWriter(operatorFile)) {
            writer.write("code,name,surname,email\n"); // header
            for (String line : csvLines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to update operator CSV", e);
        }
    }

    @Override
    public List<String> exportOperatorsToCSV(String filter) {
        return getOperators().stream()
                .filter(o -> filter == null || o.getCode().contains(filter))
                .map(this::toCsvLine)
                .collect(Collectors.toList());
    }

    @Override
    public Operator getOperator(String code) {
        return getOperators().stream()
                .filter(o -> o.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }

    /* ---------------- Helpers ---------------- */

    private String toCsvLine(Operator o) {
        return String.join(",",
                safe(o.getCode()),
                safe(o.getName()),
                safe(o.getSurname()),
                safe(o.getEmail())
        );
    }

    private String safe(Object o) {
        return o == null ? "" : o.toString();
    }
}

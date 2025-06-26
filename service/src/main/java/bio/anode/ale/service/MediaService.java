package bio.anode.ale.service;

import java.util.List;

import bio.anode.ale.core.specifications.Media;

public interface MediaService {
    List<Media> getMedia();
 
    void updateMediaFromStrings(List<String> var1);
 
    List<String> exportMediaToCSV(String var1);
 
    Media getMedium(String var1);
 }

package bio.anode.ale.core.specifications;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuildVersion {
    private Date date;
    private int majorVersion;
    private int minorVersion;
    private int patchVersion;
}

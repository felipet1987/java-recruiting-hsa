package cl.talavera.api.core.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Category {
    private String name;
    private int relevance;
    private String icon;
    private String large;




}

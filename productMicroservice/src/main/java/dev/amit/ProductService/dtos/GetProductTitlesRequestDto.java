package dev.amit.ProductService.dtos;

import java.util.List;

public class GetProductTitlesRequestDto {

    private List<String> uuids;

    public List<String> getUuids() {
        return uuids;
    }

    public void setUuids(List<String> uuids) {
        this.uuids = uuids;
    }
}

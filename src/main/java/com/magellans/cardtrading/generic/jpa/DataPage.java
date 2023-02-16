package com.magellans.cardtrading.generic.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DataPage<T> {
    private int page = 0;

    private long totalElements = 0;

    private int totalPages = 0;

    private long elementsInPage = 0;

    private List<T> contents = new ArrayList<>();

    public DataPage(int page, long totalElements, int totalPages, int elementsInPage, List<T> content) {
        this.page = page;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.elementsInPage = elementsInPage;
        this.contents = content;
    }

    public T getFirstItem() {
        if (contents != null && contents.size() > 0)
            return contents.get(0);
        return null;
    }
}

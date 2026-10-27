package com.bigobooks.util;

import org.springframework.data.domain.Page;

import com.bigobooks.dto.Envelope;
import com.bigobooks.dto.Pagination;

public final class Envelopes {

    private Envelopes() {
    }

    public static Envelope single(Object data) {
        Envelope envelope = new Envelope();
        envelope.setData(data);
        return envelope;
    }

    public static Envelope page(Page<?> page, Object data) {
        Envelope envelope = new Envelope();
        envelope.setData(data);
        envelope.setPagination(pagination(page));
        return envelope;
    }

    public static Pagination pagination(Page<?> page) {
        Pagination pagination = new Pagination();
        pagination.setPage(page.getNumber());
        pagination.setSize(page.getSize());
        pagination.setTotalElements(page.getTotalElements());
        pagination.setTotalPages(page.getTotalPages());
        return pagination;
    }
}

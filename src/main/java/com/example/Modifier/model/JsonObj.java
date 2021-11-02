package com.example.Modifier.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class JsonObj {
    @Getter
    @Setter
    private AtomicInteger current;
}

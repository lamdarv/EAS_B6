package com.ets.lamda.geraiservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "gerai")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Gerai {

    @Id
    private String id;
    private String name;
    private String address;
}
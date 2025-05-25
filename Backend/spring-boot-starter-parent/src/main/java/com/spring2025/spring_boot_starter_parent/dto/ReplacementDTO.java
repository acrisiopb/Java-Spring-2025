package com.spring2025.spring_boot_starter_parent.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ReplacementDTO {

    private Integer sourceIndex;
    private Integer destinationIndex;

}

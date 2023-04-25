package pl.sda.micgeb.springthymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Size(min = 2, max = 10)
    private String title;

    @NotBlank(message = "Nie może być puste!")
    private String author;
}

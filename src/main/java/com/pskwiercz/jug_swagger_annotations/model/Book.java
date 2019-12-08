package com.pskwiercz.jug_swagger_annotations.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@ApiModel(description = "All details about the book.")
public class Book {

        @Id
        @ApiModelProperty(value = "Book ID", required = true, position = 1)
        private long id;

        @ApiModelProperty(value = "Author of the book", example="John Dole", position = 2)
        private String author;

        @ApiModelProperty(value = "Title of the book", position = 3)
        private String title;

        @ApiModelProperty(value = "Number of pages", position = 4)
        private int pages;

        @ApiModelProperty(value = "Discount availability", position = 5)
        private boolean discount;
}

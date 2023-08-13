package com.GreenStitch.exceptions;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Error {
	private String message;
	private String description;
	private LocalDateTime timestamp;
}

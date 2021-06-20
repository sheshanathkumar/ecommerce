package com.sk.ecom.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shesh
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<String> caategories;

}

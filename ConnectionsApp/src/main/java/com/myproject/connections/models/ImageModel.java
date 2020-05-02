package com.myproject.connections.models;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageModel implements Serializable {

	private static final long serialVersionUID = 4835979957445506346L;
	
	private String imagename;
	
	private String type;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] pic;	
	
	
	
}

package com.ysd.boot.tool;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenUntil implements Serializable{

	private String access_token;
	private String token_type;
	private String bearer;
	private String refresh_token;
	private Integer expires_in;
	private String scope;
	
	
}

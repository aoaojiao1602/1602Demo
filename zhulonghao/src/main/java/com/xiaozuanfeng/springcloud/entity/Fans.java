package com.xiaozuanfeng.springcloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "fanstb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fans {
	@Id
	@GeneratedValue
	@Column(columnDefinition = "int unsigned NOT NULL comment '备注:粉丝自动增长主键' ")
	private Integer f_fid;
	@Column(columnDefinition = "int comment '备注:用户id'")
	private Integer f_uid;
	@Column(columnDefinition = "int comment '备注:粉丝id'")
	private Integer f_ufid;

	@Override
	public String toString() {
		return "Fans [f_fid=" + f_fid + ", f_uid=" + f_uid + ", f_ufid=" + f_ufid + "]";
	}

}

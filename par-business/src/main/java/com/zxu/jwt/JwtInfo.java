package com.zxu.jwt;


public class JwtInfo {
	private String loginId;
	private String loginName;
	private Long version;

	public String getLoginName() {
		return loginName;
	}

	public String getLoginId() {
		return loginId;
	}

	public Long getVersion() {
		return version;
	}

	public JwtInfo(String loginId, String loginName, Long version) {
		this.loginId = loginId;
		this.loginName = loginName;
		this.version = version;
	}

	@Override
	public String toString() {
		return "JwtInfo{" +
				"loginId='" + loginId + '\'' +
				", loginName='" + loginName + '\'' +
				", version=" + version +
				'}';
	}
}

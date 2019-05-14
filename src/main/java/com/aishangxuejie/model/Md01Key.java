package com.aishangxuejie.model;

/**
 * @author: Cuigm
 * @ClassName:  Md01Key
 * @Description: TODO
 * @date: 2019年5月14日上午9:13:18
 */
public class Md01Key {
	
	private String md001;
	private String aab301;
	public String getMd001() {
		return md001;
	}
	public void setMd001(String md001) {
		this.md001 = md001;
	}
	public String getAab301() {
		return aab301;
	}
	public void setAab301(String aab301) {
		this.aab301 = aab301;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aab301 == null) ? 0 : aab301.hashCode());
		result = prime * result + ((md001 == null) ? 0 : md001.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Md01Key other = (Md01Key) obj;
		if (aab301 == null) {
			if (other.aab301 != null)
				return false;
		} else if (!aab301.equals(other.aab301))
			return false;
		if (md001 == null) {
			if (other.md001 != null)
				return false;
		} else if (!md001.equals(other.md001))
			return false;
		return true;
	}

}

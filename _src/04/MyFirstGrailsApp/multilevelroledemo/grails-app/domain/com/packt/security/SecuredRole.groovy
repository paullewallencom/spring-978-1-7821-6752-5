package com.packt.security

class SecuredRole {

	String authority

	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
	}

	/*static hasMany = [people: SecuredUser]

	String description
	String authority

	static constraints = {
		authority(blank: false, unique: true)
	}	*/
}

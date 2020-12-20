package com.packt

class SecuredUser {

	//transient springSecurityService
	transient passwordEncoder

	String username
	String password
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	static constraints = {
		username blank: false, unique: true
		password blank: false
	}

	static mapping = {
		password column: '`password`'
	}

	Set<SecuredRole> getAuthorities() {
		SecuredUserSecuredRole.findAllBySecuredUser(this).collect { it.securedRole } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		//password = springSecurityService.encodePassword(password)
		 password = passwordEncoder.encodePassword(password, username) 
	}
}

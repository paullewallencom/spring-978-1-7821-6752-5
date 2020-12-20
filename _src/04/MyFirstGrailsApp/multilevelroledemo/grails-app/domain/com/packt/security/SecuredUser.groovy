package com.packt.security

class SecuredUser {

	transient springSecurityService

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
		password = springSecurityService.encodePassword(password)
	}
	
	/*static transients = ['pass']
	static hasMany = [authorities: SecuredRole]
	static belongsTo = SecuredRole

	String username
	String userRealName
	String passwd
	boolean enabled

	String email
	boolean emailShow

	String description = ''

	String pass = '[secret]'

	static constraints = {
		username(blank: false, unique: true)
		userRealName(blank: false)
		passwd(blank: false)
	}*/
}

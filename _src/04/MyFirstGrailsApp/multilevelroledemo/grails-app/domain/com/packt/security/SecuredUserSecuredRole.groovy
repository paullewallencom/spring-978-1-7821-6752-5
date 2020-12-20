package com.packt.security

import org.apache.commons.lang.builder.HashCodeBuilder

class SecuredUserSecuredRole implements Serializable {

	SecuredUser securedUser
	SecuredRole securedRole

	boolean equals(other) {
		if (!(other instanceof SecuredUserSecuredRole)) {
			return false
		}

		other.securedUser?.id == securedUser?.id &&
			other.securedRole?.id == securedRole?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (securedUser) builder.append(securedUser.id)
		if (securedRole) builder.append(securedRole.id)
		builder.toHashCode()
	}

	static SecuredUserSecuredRole get(long securedUserId, long securedRoleId) {
		find 'from SecuredUserSecuredRole where securedUser.id=:securedUserId and securedRole.id=:securedRoleId',
			[securedUserId: securedUserId, securedRoleId: securedRoleId]
	}

	static SecuredUserSecuredRole create(SecuredUser securedUser, SecuredRole securedRole, boolean flush = false) {
		new SecuredUserSecuredRole(securedUser: securedUser, securedRole: securedRole).save(flush: flush, insert: true)
	}

	static boolean remove(SecuredUser securedUser, SecuredRole securedRole, boolean flush = false) {
		SecuredUserSecuredRole instance = SecuredUserSecuredRole.findBySecuredUserAndSecuredRole(securedUser, securedRole)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}

	static void removeAll(SecuredUser securedUser) {
		executeUpdate 'DELETE FROM SecuredUserSecuredRole WHERE securedUser=:securedUser', [securedUser: securedUser]
	}

	static void removeAll(SecuredRole securedRole) {
		executeUpdate 'DELETE FROM SecuredUserSecuredRole WHERE securedRole=:securedRole', [securedRole: securedRole]
	}

	static mapping = {
		id composite: ['securedRole', 'securedUser']
		version false
	}
}

package multilevelroledemo
import grails.plugins.springsecurity.Secured
class SampleController {

   def index = {}

	@Secured(['ROLE_USER'])
	def user = {
		render 'Secured for ROLE_USER'
	}

	@Secured(['ROLE_ADMIN'])
	def admin = {
		render 'Secured for ROLE_ADMIN'
	}

	@Secured(['ROLE_SUPERADMIN'])
	def superadmin = {
		render 'Secured for ROLE_SUPERADMIN'
	}
}

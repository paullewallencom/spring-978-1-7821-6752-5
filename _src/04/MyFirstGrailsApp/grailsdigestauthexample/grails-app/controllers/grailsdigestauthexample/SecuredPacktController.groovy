package grailsdigestauthexample
import grails.plugins.springsecurity.Secured
class SecuredPacktController {
@Secured(['ROLE_USER'])
    def index() { 
	render "Hello PACKT"
	}
}

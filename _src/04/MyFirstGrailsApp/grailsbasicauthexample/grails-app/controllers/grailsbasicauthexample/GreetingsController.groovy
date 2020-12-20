package grailsbasicauthexample
import grails.plugins.springsecurity.Secured
class GreetingsController {
@Secured(['ROLE_USER'])
    def index() { 
	render "Hello PACKT"
	}
}

grails.project.work.dir = 'target'

grails.project.dependency.resolution = {

	inherits 'global'
	log 'warn'

	repositories {
		grailsCentral()
		mavenLocal()
		mavenCentral()
	}

	dependencies {

		runtime 'org.apache.tomcat:tomcat-jdbc:7.0.40', {
			excludes 'tomcat-juli'
		}

		runtime 'org.apache.tomcat:tomcat-juli:7.0.40'
	}

	plugins {
		build ':release:2.2.1', ':rest-client-builder:1.0.3', {
			export = false
		}
	}
}

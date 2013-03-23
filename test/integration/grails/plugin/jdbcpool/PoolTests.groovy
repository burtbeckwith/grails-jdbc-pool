package grails.plugin.jdbcpool

import java.lang.reflect.Proxy
import java.sql.Connection

import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy

class PoolTests extends GroovyTestCase {

	def dataSource
	def dataSource_ds2
	def dataSourceUnproxied
	def dataSourceUnproxied_ds2

	void testPoolsAreReconfigured() {
		assert dataSource instanceof TransactionAwareDataSourceProxy
		assert dataSource_ds2 instanceof TransactionAwareDataSourceProxy

		assert 'org.apache.tomcat.jdbc.pool.DataSource' == dataSourceUnproxied.getClass().name
		assert 'org.apache.tomcat.jdbc.pool.DataSource' == dataSourceUnproxied_ds2.getClass().name
	}

	void testPoolsWork() {
		dataSource.getConnection().close()
		dataSource_ds2.getConnection().close()
		dataSourceUnproxied.getConnection().close()
		dataSourceUnproxied_ds2.getConnection().close()
	}
}

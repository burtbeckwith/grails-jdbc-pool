rm -rf target/release
mkdir target/release
cd target/release
git clone git@github.com:burtbeckwith/grails-jdbc-pool.git
cd grails-jdbc-pool
grails clean
grails compile
#grails publish-plugin --noScm --snapshot --stacktrace
grails publish-plugin --noScm --stacktrace

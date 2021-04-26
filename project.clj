(defproject vmware "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :main "vmware.core"
  :dependencies [
                 [org.clojure/clojure "1.10.1"]
                 [org.clojure/java.classpath "1.0.0"]                 
                 [com.vmware.vapi/vapi-runtime "2.19.0"]
                 [com.vmware/vsphereautomation-client-sdk "3.5.0"]
                 [com.vmware/vsphere-samples-nodeps "7.0.2.0"]
                 [clojure.java-time "0.3.2"]
                 ]
  :repl-options {:init-ns vmware.core})

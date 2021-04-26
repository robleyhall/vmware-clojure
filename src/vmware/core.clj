(ns vmware.core
   (:gen-class
    :extends SamplesAbstractBase
    :name ListVMs))

(import
 vmware.samples.common.authentication.VapiAuthenticationHelper
 vmware.samples.common.authentication.VimAuthenticationHelper
 com.vmware.vcenter.VM
 com.vmware.vapi.protocol.HttpConfiguration
 com.vmware.vapi.protocol.HttpConfiguration$Builder
 vmware.samples.common.SslUtil
 vmware.samples.common.SamplesAbstractBase
 com.vmware.vapi.protocol.HttpConfiguration$SslConfiguration
 com.vmware.vapi.protocol.HttpConfiguration$SslConfiguration$Builder
 )

;; (def sf (.getStubFactory vapiauthhelper))

;; (def vmservice (.createStub sf VM))

;; (def sessionStubConfig (.loginByUsernameAndPassword vapiauthhelper "" "" "" httpconfig))
            ;; sslConfig = new SslConfiguration.Builder()
            ;; 		.disableCertificateValidation()
            ;; 		.disableHostnameVerification()
            ;; 		.getConfig();


(defn buildSslConfiguration []
  (SslUtil/trustAllHttpsCertificates)
  (-> (HttpConfiguration$SslConfiguration$Builder.)
      (.disableCertificateValidation)
      (.disableHostnameVerification)
      (.getConfig)
      )
  )

;; login method
    ;; protected void login() throws Exception {
    ;;     this.vapiAuthHelper = new VapiAuthenticationHelper();
    ;;     this.vimAuthHelper = new VimAuthenticationHelper();
    ;;     HttpConfiguration httpConfig = buildHttpConfiguration();
    ;;     this.sessionStubConfig =
    ;;             vapiAuthHelper.loginByUsernameAndPassword(
    ;;                 this.server, this.username, this.password, httpConfig);
    ;;     this.vimAuthHelper.loginByUsernameAndPassword(
    ;;                 this.server, this.username, this.password);
;; }

    ;; protected HttpConfiguration buildHttpConfiguration() throws Exception {
    ;;     HttpConfiguration httpConfig =
    ;;         new HttpConfiguration.Builder()
    ;;         .setSslConfiguration(buildSslConfiguration())
    ;;         .getConfig();
        
    ;;     return httpConfig;
    ;;     }

(defn buildHttpConfiguration []
  (def httpconfigbuilder (HttpConfiguration$Builder.))
;  (def httpConfig
    (-> (HttpConfiguration$Builder.)
        (.setSslConfiguration (buildSslConfiguration))
        (.getConfig)
        )
  )

(defn login []
  (def vapiauthhelper (VapiAuthenticationHelper.))
  (def vimAuthHelper (VimAuthenticationHelper.))
  ;;  (def httpConfig (buildHttpConfiguration))
  (buildHttpConfiguration)
  ;;(.loginByUsernameAndPassword vapiauthhelper "" "" "" (buildHttpConfiguration))
  )


(defn -main
  [& args]
  (println "-main running")
  (println (str "args:" args))
  (login)
  )


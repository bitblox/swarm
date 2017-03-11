node("slave") {
    git url: "http://skynet:8081/${serviceName}.git"
    def flow = load "/data/scripts/workflow-util.groovy"
    flow.provision("production.yml")
    flow.buildTests(serviceName, registryIpPort)
    flow.runTests(serviceName, "tests", "")
    flow.buildService(serviceName, registryIpPort)
    flow.deploy(serviceName, prodIp)
    flow.updateProxy(serviceName, "production")
    flow.runTests(serviceName, "integ", "-e DOMAIN=http://${proxyIp}")
}

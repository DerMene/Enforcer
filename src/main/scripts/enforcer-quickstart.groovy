/**
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
import org.grails.cli.interactive.completers.DomainClassCompleter

description("Installs default implmentaiton for Enforcer, whch can be changed/enhanced by the user") {
    usage "grails enforcer-quickstart [package]"
    argument name: 'package', description: 'The name of the package to put the enforcer files under'
    completer DomainClassCompleter
}

model = [packageName: args[0]]
dir = args[0].replace('.', '/')

addStatus "Installing Enforcer defaults"


render template: template("DomainRole.groovy"),
        destination: file("grails-app/domain/${dir}/DomainRole.groovy"),
        model: model,
        overwrite: true

render template: template("DomainRoleTrait.groovy"),
        destination: file("grails-app/services/${dir}/DomainRoleTrait.groovy"),
        model: model,
        overwrite: true

render template: template("EnforcerService.groovy"),
        destination: file("grails-app/services/${dir}/EnforcerService.groovy"),
        model: model,
        overwrite: true

render template: template("RoleTrait.groovy"),
        destination: file("grails-app/services/${dir}/RoleTrait.groovy"),
        model: model,
        overwrite: true



render template: template("EnforcerServiceSpec.groovy"),
        destination: file("src/test/groovy/unit/services/${dir}/EnforcerServiceSpec.groovy"),
        model: model,
        overwrite: true



addStatus "Installing Enforcer defaults complete"

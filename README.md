# itea - itea-be

A java web application using spring boot 3.3.5 and running with JRE 17.

[[_TOC_]]

---


## How to work on this project

### Software requirements

List of tools to be installed:

- IDE - we recommend [IntelliJ Community Edition](https://www.jetbrains.com/idea/download/#section=windows)
- JDK 17 (can be downloaded by IntelliJ)
- Maven v3.9 - build tool (can be downloaded by IntelliJ and embedded in the repo `mvnw`)

### How to start developing

Clone the repo, and open it in IntelliJ. Select the correct SDK (JDK 17) in **File → project structure**.


### How to run locally

#### Development server

Run `mvn spring-boot:run` for a dev server. This will open your browser on http://localhost:8080/. The app will automatically reload if you change any of the source files.

#### Build

Run the below command to build the project. The build artifacts will be stored in the target/ directory.

```bash
mvnw package -Dmaven.test.skip -s settings.xml -q
```

The `target` folder including these three notable folders:

classes - The project compiled .class files.

reports - Reports produced by the build (such as test reports).

libs - Assembled project libraries (usually JAR and/or WAR files).

#### Test

Run the below command to test the project. It measuring code coverage in a code base and reporting it through visual reports using JaCoCo. The test report will be stored in the `target/site` directory.

```bash
mvnw verify -s settings.xml -q
```

#### Deploy snapshots/releases

If you are running the pipeline of this project, we redefined the `upload-artifact` job as an example to show how you can push the generated Maven artifacts into any maven repository (GitLab package registry, Nexus, SSG Artifactory, or any other Maven repository).

Mandatory variables:

| variable | default value | description |
|----------|---------------|-------------|
| UPLOAD_RELEASES_REPO_URL |  | (string) URL of your releases repository. Example: `https://innersource.soprasteria.com/projects/${CI_PROJECT_ID}/packages/maven` |
| UPLOAD_SNAPSHOTS_REPO_URL |  | (string) URL of your snapshots repository. Example: `https://innersource.soprasteria.com/projects/${CI_PROJECT_ID}/packages/maven` |

Optional variables :

| variable | default value | description |
|----------|---------------|-------------|
| UPLOAD_ARTIFACT_USERNAME | `${CI_DEPLOY_USER}` | (string) Username to login to your Maven repository.|
| UPLOAD_ARTIFACT_PASSWORD | `${CI_DEPLOY_PASSWORD}` | (string) Password to login to your Maven repository. |

If you are providing only `UPLOAD_XXX_REPO_URL` variables as input, this should correspond to the GitLab Maven package registry of your project, because by default the job will use the credentials corresponding to this registry (this requires to have created a [GitLab Deploy Token](https://docs.gitlab.com/ee/user/project/deploy_tokens/) with the scope of `write_package_registry` beforehand).
To upload your Maven package into another repository, you'll have to provide `UPLOAD_XXX_REPO_URL` as well as the credentials `UPLOAD_ARTIFACT_USERNAME` and `UPLOAD_ARTIFACT_PASSWORD` corresponding to the Maven repository you're targeting.

You can also use the SSG Artifactory to push your artifacts. For more details regarding the SSG Artifactory, please refer to [this page](https://steria.sharepoint.com/sites/intra_all_indus/SitePages/TOO-Artifactory--Overview.aspx).

### Further help
* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.1/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.1/maven-plugin/reference/html/#build-image)

## Recommended development workflow

With GitFlow, the main branch should always be releasable to production, and there should never be untested or incomplete code on the main branch.

When using this Git workflow, no one commits to the main branch but rather uses a feature and fix branches. Feature and fix branches are branches created by the developers to commit their modifications. Merge requests are then opened with these branches as the source and targeting the main branch (or production branch if it is a hotfix).

Once the changes are merged to main branch, merge requests are then opened with this main branch as the source and target the production branch

```mermaid
   gitGraph
      commit
      commit
      branch feature
      branch production
      checkout feature
      commit
      commit
      checkout main
      merge feature
      commit
      commit
      checkout production
      merge main
```

In short, we distinguish 4 types of branches:

| Branch                | Naming convention (prefix)      | Description    |
|-----------------------|---------------------------------|----------------|
| Main branch(es)       | master,main,dev                 | The main branch contains the work done for the incoming release and is the base branch for any new feature or bug fix.<br>Your team should open merge requests targeting this branch when working on the project.<br>*There is usually a single main branch per project but if your team is developing several versions simultaneously then you can have versioned main branches, e.g. `main/vX.X.X`.* |
| Test branches         | staging,pre-prod,qualif,qa,test | Test branches are optional. They are useful when you have a Continuous Deployment pipeline that is able to create a new test/qualification environment on the fly.<br>In that case you can have as many test environment as necessary and you merge from one to another until the product is ready for production. |
| Production branch(es) | prod,rel                        | The production branch represents the version of your application currently deployed to production.<br>It is the base branch for any new hot fix that should quickly be shipped to production.<br>*There is usually a single production branch per project but if your team is maintaining several versions simultaneously then it is handy to have versioned release/production branches, e.g. `rel/vX.X.X`.* |
| Feature/Fix branches  | feat,ft,hotfix,fix,dependabot,renovate   | Feature and fix branches are branches created by the developers to commit their modifications. Merge requests are then opened with these branches as the source and targeting the main branch (or production branch if it is a hotfix).<br>These branches must have a short lifespan, they must be integrated or deleted as fast as possible. |



## Security concerns

The DEP updates the original template regularly but you can not benefit automatically from the updates.

In all cases, the project is responsible for assessing and mitigating security issues on their repositories.

The OCI images used in [.gitlab-ci.yml](.gitlab-ci.yml) file are built from the [dep/library/project-oci-images](dep/library/project-oci-images) repository. You can check periodically for potential updates of these images.


## How to improve this template

This GitLab project template has been generated dynamically using [mustache templating](https://mustache.github.io/). If you want to help the DEP team improve this template, please open an issue or a merge request at [dep/library/dynamic-project-templates](https://innersource.soprasteria.com/dep/library/dynamic-project-templates).



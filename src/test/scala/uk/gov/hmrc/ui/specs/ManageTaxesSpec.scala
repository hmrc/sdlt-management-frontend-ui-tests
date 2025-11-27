/*
 * Copyright 2025 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.ui.specs

import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.verbs.ShouldVerb
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.ui.pages.{AddNewAgentPage, AgentDetailsPage, AuthWizard, DueForDeletionReturnsPage, FeedbackPage, HomePage, HowToPayPage, InProgressReturnsPage, SubmittedReturnsPage}
import uk.gov.hmrc.ui.util.Users.LoginTypes.HASDIRECT
import uk.gov.hmrc.ui.util.Users.UserTypes.{Agent, Organisation}

class ManageTaxesSpec
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("SDLT Management Jounery tests") {
    Scenario("Manage Returns Homepage Links") {
      Given("User enters login using the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "STN001")
      Then("User should be navigated to the home page")
      HomePage.verifyPageTitle(HomePage.pageTitle)

      // In-Progress Returns Link
      When("User clicks on the Returns in progress link on the homepage")
      HomePage.click(HomePage.inProgressReturnLink)
      Then("User should be navigated in-progress return page")
      InProgressReturnsPage.verifyPageTitle(InProgressReturnsPage.pageTitle)
      When("User click on Back Link on the Returns in progress")
      InProgressReturnsPage.clickBackLink()
      Then("User should be navigated to the home page")
      HomePage.verifyPageTitle(HomePage.pageTitle)

      // Submitted Returns Link
      When("User clicks on the Submitted returns link on the homepage")
      HomePage.click(HomePage.submittedReturnsLink)
      Then("User should be navigated submitted returns page")
      SubmittedReturnsPage.verifyPageTitle(SubmittedReturnsPage.pageTitle)
      When("User click on Back Link on the Submitted returns")
      SubmittedReturnsPage.clickBackLink()
      Then("User should be navigated to the home page")
      HomePage.verifyPageTitle(HomePage.pageTitle)

      // Due for Deletion Link
      When("User clicks on the due for deletion link on the homepage")
      HomePage.click(HomePage.dueForDeletionLink)
      Then("User should be navigated due for deletion page")
//      DueForDeletionReturnsPage.verifyPageTitle(DueForDeletionReturnsPage.pageTitle)
      When("User click on Back Link on the due for deletion page")
      DueForDeletionReturnsPage.navigateBackToPage()
      Then("User should be navigated to the home page")
      HomePage.verifyPageTitle(HomePage.pageTitle)
    }

    Scenario("Manage Agents Homepage Links") {
      Given("User enters login using the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "STN002")
      Then("User should be navigated to the home page")
      HomePage.verifyPageTitle(HomePage.pageTitle)

      // Manage Agents Link
      When("User clicks on the manage agents link on the homepage")
      HomePage.click(HomePage.agentsDetailsLink)
      Then("User should be navigated agent overview page")
      AgentDetailsPage.verifyPageTitle(AgentDetailsPage.pageTitle)
      When("User click on Back Link on the Agent overview page")
      AgentDetailsPage.navigateBackToPage()
      Then("User should be navigated to the home page")
      HomePage.verifyPageTitle(HomePage.pageTitle)

      // Add new agent Link
      When("User clicks on the add new agent link on the homepage")
      HomePage.click(HomePage.addANewAgentLink)
      Then("User should be navigated what is agent's name page")
      AddNewAgentPage.verifyPageTitle(AddNewAgentPage.pageTitle)
      When("User click on Back Link on the What is agent's name page")
      AddNewAgentPage.navigateBackToPage()
      Then("User should be navigated to the home page")
      HomePage.verifyPageTitle(HomePage.pageTitle)
    }

    Scenario("Service feedback journey") {
      Given("User enters login using the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "STN001")
      Then("User should be navigated to the home page")
      HomePage.verifyPageTitle(HomePage.pageTitle)

      // leave feedback Link
      When("User clicks on the leave feedback link on the homepage")
      HomePage.click(HomePage.leaveFeedbackLink)
      Then("User should be navigated to the feedback page")
      FeedbackPage.fillFeedbackForm()
      Then("User should be navigated to the home page")
      HomePage.verifyPageTitle(HomePage.pageTitle)
    }

    Scenario("Help and contact links") {
      Given("User enters login using the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "STN001")
      Then("User should be navigated to the home page")
      HomePage.verifyPageTitle(HomePage.pageTitle)

      // how to pay Link
      When("User verifies how to pay link on the homepage")
      HomePage.waitForVisibilityOfElement(HomePage.howToPayLink)
      HowToPayPage.verifyLink()
      //      Then("User should be navigated to how to pay page")
      //      HowToPayPage.verifyPageTitle(HowToPayPage.pageTitle)
//      When("User click on Back Link on the how to pay page")
//      HowToPayPage.navigateBackToPage()
//      Then("User should be navigated to the home page")
//      HomePage.verifyPageTitle(HomePage.pageTitle)
    }
  }

  Feature("SDLT Management Jounery tests for Agent") {
    Scenario("Manage Returns Homepage Links") {
      Given("User enters login using the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Agent, "STN001")
      Then("User should be navigated to the home page")
      HomePage.verifyPageTitle(HomePage.pageTitle)

      // In-Progress Returns Link
      When("User clicks on the Returns in progress link on the homepage")
      HomePage.click(HomePage.inProgressReturnLink)
      Then("User should be navigated in-progress return page")
      InProgressReturnsPage.verifyPageTitle(InProgressReturnsPage.pageTitle)
      When("User click on Back Link on the Returns in progress")
      InProgressReturnsPage.clickBackLink()
      Then("User should be navigated to the home page")
      HomePage.verifyPageTitle(HomePage.pageTitle)

      // Submitted Returns Link
      When("User clicks on the Submitted returns link on the homepage")
      HomePage.click(HomePage.submittedReturnsLink)
      Then("User should be navigated submitted returns page")
      SubmittedReturnsPage.verifyPageTitle(SubmittedReturnsPage.pageTitle)
      When("User click on Back Link on the Submitted returns")
      SubmittedReturnsPage.clickBackLink()
      Then("User should be navigated to the home page")
      HomePage.verifyPageTitle(HomePage.pageTitle)

      // Due for Deletion Link
      When("User clicks on the due for deletion link on the homepage")
      HomePage.click(HomePage.dueForDeletionLink)
      Then("User should be navigated due for deletion page")
      //      DueForDeletionReturnsPage.verifyPageTitle(DueForDeletionReturnsPage.pageTitle)
      When("User click on Back Link on the due for deletion page")
      DueForDeletionReturnsPage.navigateBackToPage()
      Then("User should be navigated to the home page")
      HomePage.verifyPageTitle(HomePage.pageTitle)
    }

    /* Scenario("Manage Agents Homepage Links") {
      Given("User enters login using the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "STN002", Some("AGENT"), Some("IR-SDLT-AGENT"))
      Then("User should be navigated to the home page")
      HomePage.verifyPageTitle(HomePage.pageTitle)

      // Manage Agents Link
      When("User clicks on the manage agents link on the homepage")
      HomePage.click(HomePage.agentsDetailsLink)
      Then("User should be navigated agent overview page")
      AgentDetailsPage.verifyPageTitle(AgentDetailsPage.pageTitle)
      When("User click on Back Link on the Agent overview page")
      AgentDetailsPage.navigateBackToPage()
      Then("User should be navigated to the home page")
      HomePage.verifyPageTitle(HomePage.pageTitle)

      // Add new agent Link
      When("User clicks on the add new agent link on the homepage")
      HomePage.click(HomePage.addANewAgentLink)
      Then("User should be navigated what is agent's name page")
      AddNewAgentPage.verifyPageTitle(AddNewAgentPage.pageTitle)
      When("User click on Back Link on the What is agent's name page")
      AddNewAgentPage.navigateBackToPage()
      Then("User should be navigated to the home page")
      HomePage.verifyPageTitle(HomePage.pageTitle)
    }*/

    Scenario("Service feedback journey") {
      Given("User enters login using the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Agent, "STN001")
      Then("User should be navigated to the home page")
      HomePage.verifyPageTitle(HomePage.pageTitle)

      // leave feedback Link
      When("User clicks on the leave feedback link on the homepage")
      HomePage.click(HomePage.leaveFeedbackLink)
      Then("User should be navigated to the feedback page")
      FeedbackPage.fillFeedbackForm()
      Then("User should be navigated to the home page")
      HomePage.verifyPageTitle(HomePage.pageTitle)
    }

    Scenario("Help and contact links") {
      Given("User enters login using the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Agent, "STN001")
      Then("User should be navigated to the home page")
      HomePage.verifyPageTitle(HomePage.pageTitle)

      // how to pay Link
      When("User clicks on the how to pay link on the homepage")
      HomePage.click(HomePage.howToPayLink)
      Then("User should be navigated to how to pay page")
      HowToPayPage.verifyPageTitle(HowToPayPage.pageTitle)
      When("User click on Back Link on the how to pay page")
      HowToPayPage.navigateBackToPage()
      Then("User should be navigated to the home page")
      HomePage.verifyPageTitle(HomePage.pageTitle)
    }
  }
}

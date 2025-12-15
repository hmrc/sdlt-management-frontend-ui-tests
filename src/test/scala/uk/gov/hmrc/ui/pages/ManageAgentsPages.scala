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

package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By

object AgentDetailsPage extends BasePage {

  override def pageUrl: String = "/manage-returns/submitted-return"

  override def pageTitle: String =
    "Agent overview – Agent details - Stamp Taxes Online - GOV.UK"
}

object AddNewAgentPage extends BasePage {

  override def pageUrl: String = "/manage-returns/submitted-return"

  override def pageTitle: String =
    "What is the agent’s name? – Agent details - Stamp Taxes Online - GOV.UK"
}

object ChangeAddressPage extends BasePage {

  override def pageUrl: String =
    "/manage-returns/agent/change-address" // <-- use correct route for your service

  override def pageTitle: String =
    "Check the agent’s address – Agent details - Stamp Taxes Online - GOV.UK"

  val feedBackPageForAddress: String =
    "Send your feedback – Contact HMRC – GOV.UK"

  def lnkChangeAgent(agentName: String): By =
    By.xpath(
      s"//dt[contains(normalize-space(), '$agentName')]" +
        "/following-sibling::dd//a[contains(normalize-space(), 'Change')]"
    )

  def clickChangeAgent(agentName: String): Unit = {
    waitForElementToBeClickable(lnkChangeAgent(agentName))
    click(lnkChangeAgent(agentName))
  }

  val linkChangeAgentAddress: By = By.xpath("//a[@id='change-agent-address']")

  def clickChangeAgentAddress(): Unit = {
    val element = waitForElementToBeClickable(linkChangeAgentAddress)
    element.click()
  }

}

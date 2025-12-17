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

object FeedbackPage extends BasePage {

  override def pageUrl: String = "/feedback/stamp-duty-land-tax"

  override def pageTitle: String =
    "Give feedback - GOV.UK"

  val ableToDoRadioOption: String      = "#ableToDo-Yes"
  val wasEasyRadioOption: String       = "#howEasyQuestion-VeryEasy"
  val whyGiveScoreTextArea: By         = By.id("whyGiveScore")
  val verySatisfiedRadioOption: String = "#howDoYouFeelQuestion-VerySatisfied"

  val inProgressReturnLink: By = By.xpath("//a[starts-with(normalize-space(.), 'Returns in progress')]")

  def fillFeedbackForm(): Unit = {
    // Save original tab
    val originalTab = driver.getWindowHandle

    // Switch to the newest tab (usually the last)
    val tabs = driver.getWindowHandles.toArray
    driver.switchTo().window(tabs.last.toString)

    // Perform actions in the new tab
    verifyPageTitle(FeedbackPage.pageTitle)
    radioButton(ableToDoRadioOption)
    radioButton(wasEasyRadioOption)
    input(whyGiveScoreTextArea, "Satisfied with the service.")
    radioButton(verySatisfiedRadioOption)
    clickSubmitButton()
    verifyPageTitle("Thank you for your feedback")

    // Switch back to the original tab
    driver.switchTo().window(originalTab)

    val SignOutFeedback: String =
      "Send your feedback – Contact HMRC – GOV.UK"
  }
}

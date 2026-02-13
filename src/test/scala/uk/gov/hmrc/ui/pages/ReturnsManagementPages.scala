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

object InProgressReturnsPage extends BasePage {

  override def pageUrl: String = "/manage-returns/in-progress-returns"

  override def pageTitle: String =
    "Manage returns – Returns in progress - Stamp Taxes Online - GOV.UK"
  val startNewReturnLink: By     = By.xpath("//a[starts-with(normalize-space(.), 'Start a new return')]")
}

object SubmittedReturnsPage extends BasePage {

  override def pageUrl: String = "/manage-returns/submitted-return"

  override def pageTitle: String =
    "Submitted returns – Manage returns - Stamp Taxes Online - GOV.UK"
  val startNewReturnLink: By     = By.xpath("//a[starts-with(normalize-space(.), 'Start a new return')]")
}

object DueForDeletionReturnsPage extends BasePage {

  override def pageUrl: String = "/manage-returns/returns-due-for-deletion"

  override def pageTitle: String =
    "Returns due for deletion – Manage returns - Stamp Taxes Online - GOV.UK"

  val inProgressReturnsDeletionTab: By = By.id("tab_in-progress")
  val submittedReturnsDeletionTab: By  = By.id("tab_submitted")
  val startNewReturnLink: By           = By.xpath("//a[starts-with(normalize-space(.), 'Start a new return')]")
}

object StartNewReturnPage extends BasePage {

  override def pageUrl: String = "/preliminary-questions/before-you-start"

  override def pageTitle: String =
    "Before you start a new Stamp Tax return - Preliminary questions - Stamp Taxes Online - GOV.UK"
}

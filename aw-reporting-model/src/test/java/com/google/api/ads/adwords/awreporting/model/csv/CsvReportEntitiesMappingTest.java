// Copyright 2013 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.ads.adwords.awreporting.model.csv;

import com.google.api.ads.adwords.awreporting.model.csv.CsvReportEntitiesMapping;
import com.google.api.ads.adwords.awreporting.model.entities.Report;
import com.google.api.ads.adwords.awreporting.model.entities.ReportAccount;
import com.google.api.ads.adwords.awreporting.model.entities.ReportAd;
import com.google.api.ads.adwords.awreporting.model.entities.ReportAdGroup;
import com.google.api.ads.adwords.awreporting.model.entities.ReportAgeRange;
import com.google.api.ads.adwords.awreporting.model.entities.ReportBudget;
import com.google.api.ads.adwords.awreporting.model.entities.ReportCampaign;
import com.google.api.ads.adwords.awreporting.model.entities.ReportCampaignNegativeKeywords;
import com.google.api.ads.adwords.awreporting.model.entities.ReportCriteria;
import com.google.api.ads.adwords.awreporting.model.entities.ReportDestinationUrl;
import com.google.api.ads.adwords.awreporting.model.entities.ReportDisplayKeyword;
import com.google.api.ads.adwords.awreporting.model.entities.ReportFinalUrl;
import com.google.api.ads.adwords.awreporting.model.entities.ReportGender;
import com.google.api.ads.adwords.awreporting.model.entities.ReportKeywords;
import com.google.api.ads.adwords.awreporting.model.entities.ReportPlaceholderFeedItem;
import com.google.api.ads.adwords.awreporting.model.entities.ReportShopping;
import com.google.api.ads.adwords.awreporting.model.entities.ReportVideo;
import com.google.api.ads.adwords.awreporting.model.entities.ReportUrl;
import com.google.api.ads.adwords.lib.jaxb.v201601.ReportDefinitionReportType;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

/**
 * Test case for the dynamic report bean class mapping.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aw-report-sql-beans.xml")
@ActiveProfiles("TEST")
public class CsvReportEntitiesMappingTest {

  @Autowired
  private CsvReportEntitiesMapping csvReportEntitiesMapping;

  /**
   * Tests the mapping of the bean classes that was done in the context initialization.
   */
  @Test
  public void testProperReportBeanMapping() {

    this.assertBeanClassIsCorrectForType(ReportAccount.class,
        ReportDefinitionReportType.ACCOUNT_PERFORMANCE_REPORT);

    this.assertBeanClassIsCorrectForType(ReportCampaign.class,
        ReportDefinitionReportType.CAMPAIGN_PERFORMANCE_REPORT);

    this.assertBeanClassIsCorrectForType(ReportAdGroup.class,
        ReportDefinitionReportType.ADGROUP_PERFORMANCE_REPORT);

    this.assertBeanClassIsCorrectForType(ReportAd.class,
        ReportDefinitionReportType.AD_PERFORMANCE_REPORT);
    
    this.assertBeanClassIsCorrectForType(ReportAgeRange.class,
        ReportDefinitionReportType.AGE_RANGE_PERFORMANCE_REPORT);

    this.assertBeanClassIsCorrectForType(ReportKeywords.class,
        ReportDefinitionReportType.KEYWORDS_PERFORMANCE_REPORT);

    this.assertBeanClassIsCorrectForType(ReportCampaignNegativeKeywords.class,
        ReportDefinitionReportType.CAMPAIGN_NEGATIVE_KEYWORDS_PERFORMANCE_REPORT);

    this.assertBeanClassIsCorrectForType(ReportBudget.class,
        ReportDefinitionReportType.BUDGET_PERFORMANCE_REPORT);

    this.assertBeanClassIsCorrectForType(ReportCriteria.class,
        ReportDefinitionReportType.CRITERIA_PERFORMANCE_REPORT);

    this.assertBeanClassIsCorrectForType(ReportDestinationUrl.class,
        ReportDefinitionReportType.DESTINATION_URL_REPORT);
    
    this.assertBeanClassIsCorrectForType(ReportFinalUrl.class,
        ReportDefinitionReportType.FINAL_URL_REPORT);
    
    this.assertBeanClassIsCorrectForType(ReportGender.class,
        ReportDefinitionReportType.GENDER_PERFORMANCE_REPORT);

    this.assertBeanClassIsCorrectForType(ReportPlaceholderFeedItem.class,
        ReportDefinitionReportType.PLACEHOLDER_FEED_ITEM_REPORT);

    this.assertBeanClassIsCorrectForType(ReportUrl.class,
        ReportDefinitionReportType.URL_PERFORMANCE_REPORT);

    this.assertBeanClassIsCorrectForType(ReportDisplayKeyword.class,
        ReportDefinitionReportType.DISPLAY_KEYWORD_PERFORMANCE_REPORT);
    
    this.assertBeanClassIsCorrectForType(ReportShopping.class,
        ReportDefinitionReportType.SHOPPING_PERFORMANCE_REPORT);
    
    this.assertBeanClassIsCorrectForType(ReportVideo.class,
        ReportDefinitionReportType.VIDEO_PERFORMANCE_REPORT);
  }

  /**
   * Tests that the bean classes for the reports were properly found.
   */
  @Test
  public void testMappedReports() {

    Set<ReportDefinitionReportType> reports = this.csvReportEntitiesMapping.getDefinedReports();

    Assert.assertTrue(reports.contains(ReportDefinitionReportType.ACCOUNT_PERFORMANCE_REPORT));
    Assert.assertTrue(reports.contains(ReportDefinitionReportType.CAMPAIGN_PERFORMANCE_REPORT));
    Assert.assertTrue(reports.contains(ReportDefinitionReportType.ADGROUP_PERFORMANCE_REPORT));
    Assert.assertTrue(reports.contains(ReportDefinitionReportType.AD_PERFORMANCE_REPORT));
    Assert.assertTrue(reports.contains(ReportDefinitionReportType.AGE_RANGE_PERFORMANCE_REPORT));
    Assert.assertTrue(reports.contains(ReportDefinitionReportType.KEYWORDS_PERFORMANCE_REPORT));
    Assert.assertTrue(
        reports.contains(ReportDefinitionReportType.CAMPAIGN_NEGATIVE_KEYWORDS_PERFORMANCE_REPORT));
    Assert.assertTrue(reports.contains(ReportDefinitionReportType.BUDGET_PERFORMANCE_REPORT));
    Assert.assertTrue(reports.contains(ReportDefinitionReportType.CRITERIA_PERFORMANCE_REPORT));
    Assert.assertTrue(reports.contains(ReportDefinitionReportType.DESTINATION_URL_REPORT));
    Assert.assertTrue(reports.contains(ReportDefinitionReportType.FINAL_URL_REPORT));
    Assert.assertTrue(reports.contains(ReportDefinitionReportType.GENDER_PERFORMANCE_REPORT));
    Assert.assertTrue(reports.contains(ReportDefinitionReportType.PLACEHOLDER_FEED_ITEM_REPORT));
    Assert.assertTrue(reports.contains(ReportDefinitionReportType.URL_PERFORMANCE_REPORT));
    Assert.assertTrue(reports.contains(ReportDefinitionReportType.DISPLAY_KEYWORD_PERFORMANCE_REPORT));
    Assert.assertTrue(reports.contains(ReportDefinitionReportType.SHOPPING_PERFORMANCE_REPORT));
    Assert.assertTrue(reports.contains(ReportDefinitionReportType.VIDEO_PERFORMANCE_REPORT));
  }

  /**
   * Tests that the properties to be selected are correctly mapped.
   */
  @Test
  public void testReportSelectionProperties() {

    List<String> propertiesToSelect = this.csvReportEntitiesMapping.retrievePropertiesToSelect(
        ReportDefinitionReportType.ACCOUNT_PERFORMANCE_REPORT);

    Assert.assertNotNull(propertiesToSelect);


    Assert.assertTrue(propertiesToSelect.contains("ExternalCustomerId"));

    Assert.assertTrue(propertiesToSelect.contains("AccountDescriptiveName"));
    Assert.assertTrue(propertiesToSelect.contains("AccountTimeZoneId"));
    Assert.assertTrue(propertiesToSelect.contains("CustomerDescriptiveName"));
    Assert.assertTrue(propertiesToSelect.contains("PrimaryCompanyName"));
    Assert.assertTrue(propertiesToSelect.contains("AccountCurrencyCode"));
    Assert.assertTrue(propertiesToSelect.contains("HourOfDay"));
    Assert.assertTrue(propertiesToSelect.contains("Date"));
    Assert.assertTrue(propertiesToSelect.contains("DayOfWeek"));
    Assert.assertTrue(propertiesToSelect.contains("Week"));
    Assert.assertTrue(propertiesToSelect.contains("Month"));
    Assert.assertTrue(propertiesToSelect.contains("MonthOfYear"));
    Assert.assertTrue(propertiesToSelect.contains("Quarter"));
    Assert.assertTrue(propertiesToSelect.contains("Year"));
    Assert.assertTrue(propertiesToSelect.contains("Cost"));
    Assert.assertTrue(propertiesToSelect.contains("Clicks"));
    Assert.assertTrue(propertiesToSelect.contains("Impressions"));
    Assert.assertTrue(propertiesToSelect.contains("Ctr"));
    Assert.assertTrue(propertiesToSelect.contains("AverageCost"));
    Assert.assertTrue(propertiesToSelect.contains("AverageCpm"));
    Assert.assertTrue(propertiesToSelect.contains("AverageCpc"));
    Assert.assertTrue(propertiesToSelect.contains("AverageCpe"));
    Assert.assertTrue(propertiesToSelect.contains("AverageCpv"));
    Assert.assertTrue(propertiesToSelect.contains("AveragePosition"));
    Assert.assertTrue(propertiesToSelect.contains("Device"));
    Assert.assertTrue(propertiesToSelect.contains("ClickType"));
    Assert.assertTrue(propertiesToSelect.contains("AdNetworkType1"));
    Assert.assertTrue(propertiesToSelect.contains("AdNetworkType2"));
    Assert.assertTrue(propertiesToSelect.contains("Engagements"));
    Assert.assertTrue(propertiesToSelect.contains("EngagementRate"));
    Assert.assertTrue(propertiesToSelect.contains("Interactions"));
    Assert.assertTrue(propertiesToSelect.contains("InteractionRate"));
    Assert.assertTrue(propertiesToSelect.contains("VideoViews"));
    Assert.assertTrue(propertiesToSelect.contains("VideoViewRate"));
    Assert.assertTrue(propertiesToSelect.contains("Conversions"));
    Assert.assertTrue(propertiesToSelect.contains("ConversionRate"));
    Assert.assertTrue(propertiesToSelect.contains("ConversionValue"));
    Assert.assertTrue(propertiesToSelect.contains("CostPerConversion"));
    Assert.assertTrue(propertiesToSelect.contains("ValuePerConversion"));
    Assert.assertTrue(propertiesToSelect.contains("AllConversions"));
    Assert.assertTrue(propertiesToSelect.contains("AllConversionRate"));
    Assert.assertTrue(propertiesToSelect.contains("AllConversionValue"));
    Assert.assertTrue(propertiesToSelect.contains("CostPerAllConversion"));
    Assert.assertTrue(propertiesToSelect.contains("ValuePerAllConversion"));
    Assert.assertTrue(propertiesToSelect.contains("CrossDeviceConversions"));
    Assert.assertTrue(propertiesToSelect.contains("ConvertedClicks"));
    Assert.assertTrue(propertiesToSelect.contains("ClickConversionRate"));
    Assert.assertTrue(propertiesToSelect.contains("CostPerConvertedClick"));
    Assert.assertTrue(propertiesToSelect.contains("ValuePerConvertedClick"));
    Assert.assertTrue(propertiesToSelect.contains("ConversionCategoryName"));
    Assert.assertTrue(propertiesToSelect.contains("ConversionTypeName"));
    Assert.assertTrue(propertiesToSelect.contains("ViewThroughConversions"));

    Assert.assertTrue(propertiesToSelect.contains("SearchImpressionShare"));
    Assert.assertTrue(propertiesToSelect.contains("SearchBudgetLostImpressionShare"));
    Assert.assertTrue(propertiesToSelect.contains("SearchRankLostImpressionShare"));
    Assert.assertTrue(propertiesToSelect.contains("ContentImpressionShare"));
    Assert.assertTrue(propertiesToSelect.contains("ContentBudgetLostImpressionShare"));
    Assert.assertTrue(propertiesToSelect.contains("ContentRankLostImpressionShare"));
    Assert.assertTrue(propertiesToSelect.contains("SearchExactMatchImpressionShare"));

    Assert.assertTrue(propertiesToSelect.contains("CanManageClients"));
    Assert.assertTrue(propertiesToSelect.contains("IsAutoTaggingEnabled"));
    Assert.assertTrue(propertiesToSelect.contains("IsTestAccount"));
    Assert.assertTrue(propertiesToSelect.contains("ActiveViewCpm"));
    Assert.assertTrue(propertiesToSelect.contains("ActiveViewCtr"));
    Assert.assertTrue(propertiesToSelect.contains("ActiveViewImpressions"));
    Assert.assertTrue(propertiesToSelect.contains("ActiveViewMeasurability"));
    Assert.assertTrue(propertiesToSelect.contains("ActiveViewMeasurableCost"));
    Assert.assertTrue(propertiesToSelect.contains("ActiveViewMeasurableImpressions"));
    Assert.assertTrue(propertiesToSelect.contains("ActiveViewViewability"));
    Assert.assertTrue(propertiesToSelect.contains("ConversionTrackerId"));
    Assert.assertTrue(propertiesToSelect.contains("Slot"));

    Assert.assertEquals(71, propertiesToSelect.size());
  }

  /**
   * Recovers the class from the mapping, and test against the proper bean class.
   *
   * @param reportBeanClass the correct bean class.
   * @param type the report type
   */
  private void assertBeanClassIsCorrectForType(Class<? extends Report> reportBeanClass,
      ReportDefinitionReportType type) {

    Class<? extends Report> mappedBeanClass =
        this.csvReportEntitiesMapping.getReportBeanClass(type);
    Assert.assertEquals(reportBeanClass, mappedBeanClass);
  }
}

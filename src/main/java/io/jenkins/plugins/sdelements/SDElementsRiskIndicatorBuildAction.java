package io.jenkins.plugins.sdelements;

import hudson.model.Action;
import io.jenkins.plugins.sdelements.api.RiskPolicyCompliance;

/**
 * Created by mads on 4/12/18.
 */
public class SDElementsRiskIndicatorBuildAction implements Action  {

    private RiskPolicyCompliance riskIndicator;
    private String projectUrl;

    public SDElementsRiskIndicatorBuildAction(RiskPolicyCompliance riskIndicator, String projectUrl) {
        this.riskIndicator = riskIndicator;
        this.projectUrl = projectUrl;
    }

    @Override
    public String getIconFileName() {
        if(riskIndicator == null || riskIndicator == RiskPolicyCompliance.UNDETERMINED) {
            return "/plugin/sdelements/icons/none.png";
        }
        return riskIndicator == RiskPolicyCompliance.PASS ? "/plugin/sdelements/icons/pass.png" : "/plugin/sdelements/icons/fail.png";
    }

    @Override
    public String getDisplayName() {
        return "SD Elements";
    }

    @Override
    public String getUrlName() {
        return projectUrl;
    }

    public RiskPolicyCompliance getRiskIndicator() {
        return riskIndicator;
    }

    public void setRiskIndicator(RiskPolicyCompliance riskIndicator) {
        this.riskIndicator = riskIndicator;
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public void setProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl;
    }
}

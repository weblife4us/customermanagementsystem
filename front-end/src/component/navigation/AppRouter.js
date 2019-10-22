import React from 'react'
import {Route, Switch} from "react-router-dom";
import HomePage from "../Home";
import ContactUsPage from "../ContactUs";
import LoginPage from "../security/Login";
import MainPortalPage from "../portal/customerPortal/MainPortalPage";
import AllPersonsPage from "../portal/adminPortal/AllPersonsPage";
import PersonPage from "../portal/adminPortal/PersonPage";

export default function AppRouter() {
    return (
        <Switch>
            <Route exact path="/" component={HomePage}/>
            <Route exact path="/contact" component={ContactUsPage}/>
            <Route exact path="/login" component={LoginPage}/>
            <Route exact path="/portal" component={MainPortalPage}/>
            <Route exact path="/persons" component={AllPersonsPage}/>
            <Route exact path="/persons/:id" component={PersonPage}/>
        </Switch>
    )
}
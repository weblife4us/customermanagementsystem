import React, {Component} from 'react';
import {
    Collapse,
    DropdownItem,
    DropdownMenu,
    DropdownToggle,
    Nav,
    Navbar,
    NavbarBrand,
    NavbarToggler,
    NavItem,
    UncontrolledDropdown
} from 'reactstrap';
import {NavLink} from 'react-router-dom';

export default class AppNavbar extends Component {
    constructor(props) {
        super(props);
        this.state = {isOpen: false};
        this.toggle = this.toggle.bind(this);
    }

    toggle() {
        this.setState({
            isOpen: !this.state.isOpen
        });
    }

    render() {
        return (
            <Navbar color="light" light expand="md" sticky={'top'}
                    className="shadow-sm py-0 border-dark border-bottom">
                <div>
                    <Collapse isOpen={this.state.isOpen} navbar>
                        <Nav className="ml-auto" navbar>
                            <NavbarBrand to="/"><img
                                src={"https://res.cloudinary.com/go2it/image/upload/v1557970687/Go2IT_small.png"}/></NavbarBrand>
                            <NavbarToggler onClick={this.toggle}/>
                        </Nav>
                        <Nav className="ml-auto links" navbar>
                            {/*<NavItem>*/}
                            {/*    <NavLink to="/employees" activeClassName="active" className={AuthService.isAuthenticated() ? '' : 'hidden'}>View all employees</NavLink>*/}
                            {/*</NavItem>*/}
                            <NavItem>
                                <NavLink to="/contact" activeClassName="active">Contact us</NavLink>
                            </NavItem>
                            <UncontrolledDropdown nav inNavbar>
                                <DropdownToggle nav caret>
                                    Profile
                                </DropdownToggle>
                                <DropdownMenu right>
                                    <DropdownItem>
                                        <NavLink to="/login">Login</NavLink>
                                    </DropdownItem>
                                    <DropdownItem>
                                        <NavLink to="/signUp">Create account</NavLink>
                                    </DropdownItem>
                                    <DropdownItem divider/>
                                    {/*<DropdownItem>*/}
                                    {/*    <NavLink to="/logout">Logout</NavLink>*/}
                                    {/*</DropdownItem>*/}
                                </DropdownMenu>
                            </UncontrolledDropdown>
                        </Nav>
                    </Collapse>
                </div>
            </Navbar>
        );
    }
}
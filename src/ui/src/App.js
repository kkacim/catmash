import React from 'react';
import { BrowserRouter as Router, Route, Switch, NavLink} from 'react-router-dom';
import {Container, Button,ButtonGroup} from '@material-ui/core/';
import VotePage from "./components/pages/VotePage"
import BestOfPage from "./components/pages/BestOfPage"

const App = () => (
  <Container style={{textAlign: 'center'}}>  
    <Router>
        <ButtonGroup color="primary"  >
          <Button><NavLink to="/">Vote</NavLink></Button>
          <Button><NavLink to="/bestof">Best Of</NavLink></Button>
        </ButtonGroup>
      <Switch>
        <Route path='/' exact={true} component={VotePage}/>
        <Route path='/bestof' exact={true} component={BestOfPage}/>
      </Switch>
    </Router>
  </Container>
);

export default App;
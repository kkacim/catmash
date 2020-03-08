import React, {Component} from 'react';
import {Paper, Grid} from '@material-ui/core/';
import CatCard from '../common/CatCard'
import api from "../../api";

class VotePage extends Component {
    state = {
        cats: []
    }

    componentDidMount = () => {
        api.random()
            .then(cats =>
                this.setState({
                    cats
                })
            )
    }

    handleVote = winnerId => {
        api.vote(winnerId, this.state.cats.filter( cat => cat.id !== winnerId)[0].id)

        api.random()
            .then(cats =>
                this.setState({
                    cats
                })
            )
    }

    render() {
        return(
            <Paper>
                <h1>
                    Vote for the cuttest cat
                </h1>
                <Grid
                    container
                    alignItems="center"
                    justify="center"
                    spacing={6}
                    >
                    {this.state.cats.map(cat => 
                        <Grid item key={cat.id} xs={4}>
                            <CatCard cat={cat} voteAction={this.handleVote}/>
                        </Grid>
                    )}                        
                </Grid>
            </Paper>
        );
    }
}

export default VotePage;
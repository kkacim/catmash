import React, {Component} from 'react';
import {Paper, Grid} from '@material-ui/core/';
import CatCard from '../common/CatCard'
import api from "../../api";

class BestOfPage extends Component {
    state = {
        cats: []
    }

    componentDidMount = () => {
        api.bestOf()
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
                    Best of : The cutest cats
                </h1>
                <Grid
                    container
                    alignItems="center"
                    justify="center"
                    spacing={2}
                    >
                    {this.state.cats.map(cat => 
                        <Grid item key={cat.id} xs={2}>
                            <CatCard cat={cat}/>
                        </Grid>
                    )}
                </Grid>
            </Paper>
        )
    }
}

export default BestOfPage;
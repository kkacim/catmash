import React, { useState, useEffect } from 'react'
import {Paper, Grid} from '@material-ui/core/'
import CatCard from '../common/CatCard'
import api from "../../api"

const VotePage = () => {
    const [cats, setCats] = useState([])

    useEffect(() => {
        api.random()
            .then(cats => setCats(cats))
    }, [])

    const handleVote = winnerId => {
        api.vote(winnerId, cats.filter( cat => cat.id !== winnerId)[0].id)

        api.random()
            .then(cats =>setCats(cats))
    }

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
                {cats.map(cat => 
                    <Grid item key={cat.id} xs={4}>
                        <CatCard cat={cat} voteAction={handleVote}/>
                    </Grid>
                )}                        
            </Grid>
        </Paper>
    )
}

export default VotePage
import React, { useState, useEffect } from 'react'
import {Paper, Grid} from '@material-ui/core/'
import CatCard from '../common/CatCard'
import api from "../../api"

const BestOfPage = () => {
    const [cats, setCats] = useState([])

    useEffect(() => {
        api.bestOf()
            .then(cats => setCats(cats))
    }, [])

    return(
        <Paper>
            <h1>
                Best of : The cuttests cats
            </h1>
            <Grid
                container
                alignItems="center"
                justify="center"
                spacing={2}
                >
                {cats.map(cat => 
                    <Grid item key={cat.id} xs={2}>
                        <CatCard cat={cat}/>
                    </Grid>
                )}
            </Grid>
        </Paper>
    )
}

export default BestOfPage
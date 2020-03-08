import React from 'react';
import {Card, CardMedia, CardContent, CardActions, Button} from '@material-ui/core/';

const CatCard = ({cat, voteAction}) => (
    <Card>
        <CardMedia
            component='img'            
            image={cat.url}
        />
        {!voteAction 
            ?<CardContent>
                Rating: {cat.rating}
            </CardContent>
            :<CardActions style={{justifyContent: 'center'}}>
                <Button 
                    size="small" 
                    variant="contained" 
                    color="primary"
                    onClick={() => voteAction(cat.id)}
                    >
                        Vote for me
                    </Button>
            </CardActions>
        }
    </Card>
)

export default CatCard;
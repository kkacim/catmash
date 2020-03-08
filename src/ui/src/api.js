export default {
    random: () => fetch('/api/match/random').then(res => res.json()),
    vote: (winnerId, loserId) => fetch('/api/match/vote', {
      method: 'post',
      headers: {'Content-Type': 'application/x-www-form-urlencoded'},
      body: 'winnerId='+winnerId+'&loserId='+loserId
    }),
    bestOf: () => fetch('/api/match/bestof').then(res => res.json())
}
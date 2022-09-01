import Configuration from '../configurations/configuration';

class SampleService {
    constructor(){
        this.config = new Configuration();
    }

    async sampleGetCall(){
        return fetch(this.config.BASE_URL+'todos/1')
        .then(json => {
                console.log("Retrieved items:", json);
        })
        .catch(error => {
            this.handleError(error);
        });
    }
}
export default SampleService;
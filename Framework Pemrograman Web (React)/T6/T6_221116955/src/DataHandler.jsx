import client from "./client"

const loadStories = async () => {
    const url = "/stories/all?username=" + localStorage.getItem("username");
    const res = await client.get(url);
    return res.data.stories;
}

export default {loadStories}
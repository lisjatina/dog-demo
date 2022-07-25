export const getStaticPaths = async () =>{
    const res = await fetch ("http://localhost:8080/api/v1/list");
    const data = await res.json();

    const paths = data.map(user => {
        return {
            params: {id: user.id.toString()}
        }
    })

    return {
        paths,
        fallback: false
    }
}

export const getStaticProps = async (context) => {
    const id = context.params.id;
    const res = await fetch ("http://localhost:8080/api/v1/" + id);
    const data = await res.json();

    return {
        props: {dog: data}
    }
}

const Dog = ({dog}) => {
    return (
        <div>
            <p>Dog name: {dog.name}</p>
            <p>Breed: {dog.breed}</p>
            <p>Age: {dog.age}</p>
        </div>
    );
}

export default Dog;
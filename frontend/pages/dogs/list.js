import Link from "next/link";
import styles from "../../../styles/module.css"

export const getStaticProps = async () => {
    const res = await fetch ("http://localhost:8080/api/v1/list");
    const data = await res.json();

    return {
        props: {dogs: data}
    }
}

const AllDogs= ({dogs}) => {
    return ( 
        <div>
            <h1>All entered dogs</h1>
            {dogs.map(dogs => (
                <Link href={'/dogs/'+dogs.id} key={dogs.id}>
                    <a className={styles.single}>
                        <h3>{dogs.name}</h3>
                    </a>
                </Link>
            ))}
        </div>
     );
}
 
export default AllDogs;
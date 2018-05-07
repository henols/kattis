import java.util.Optional;
import java.util.stream.IntStream;

public class FileRep {

	private final String contens;
	private final Byte hash ;

	public FileRep(String contens) {
		this.contens = contens.trim();
		byte[] bytes = this.contens.getBytes();
		Optional<Byte> hash = IntStream.range(0, bytes.length).mapToObj(i -> bytes[i])
				.reduce((x, y) -> (byte) (x.byteValue() ^ y.byteValue()));

		if (hash.isPresent()) {
			this.hash = hash.get();
		} else {
			throw new RuntimeException();
		}
	}

	public Byte getHash() {
		return hash;
	}

	public Object getContens() {
		return contens;
	}

	
	@Override
	public String toString() {
		return "FileRep [contens=" + contens + ", getHash()=" + getHash() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contens == null) ? 0 : contens.hashCode());
		result = prime * result + ((hash == null) ? 0 : hash.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof FileRep)) {
			return false;
		}
		FileRep other = (FileRep) obj;
		if (hash == null) {
			if (other.hash != null) {
				return false;
			}
		} else if (!hash.equals(other.hash)) {
			return false;
		}
		if (contens == null) {
			if (other.contens != null) {
				return false;
			}
		} else if (!contens.equals(other.contens)) {
			return false;
		}
		return true;
	}

	
	

}
